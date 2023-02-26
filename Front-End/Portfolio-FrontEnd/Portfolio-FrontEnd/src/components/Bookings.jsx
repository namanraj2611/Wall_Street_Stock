import axios from 'axios'
import { useEffect, useState } from 'react'
import AdminNav from './Adminnav'
import moment from 'moment'
import { useHistory } from 'react-router-dom'

export default function Bookings() {
  const userid = sessionStorage.getItem('userid')
  const [data, setData] = useState([])
  const history = useHistory()
  const showDetails = (id) => {
    history.push('bdetails/' + id)
  }
  useEffect(() => {
    axios.get('http://localhost:8080/api/bookings').then((resp) => {
      setData(resp.data)
    })
  }, [])
  return (
    <>
      <div className='content-wrapper p-2'>
        <div
          className='container-fluid shadow p-2 bg-white'
          style={{ minHeight: '88vh' }}
        >
          <h5 className='p-2 mb-3' style={{ borderBottom: '2px solid green' }}>
            Order
          </h5>
          <table className='table table-bordered table-sm'>
            <thead>
              <tr>
                <th>Order Id</th>
                <th>Stock Category</th>
                <th> Date</th>
                <th>User Name</th>
                <th>Advance</th>
                <th>From Date</th>
                <th>To Date</th>
                {/* <th>Status</th> */}
                <th>Cancel</th>
              </tr>
            </thead>
            <tbody>
              {data.map((bk) => (
                <tr key={bk.id}>
                  <td>{bk.id}</td>
                  <td>{bk.variant.title}</td>
                  <td>{moment(bk.bookingdate).format('d-MMM-yyyy hh:mm A')}</td>
                  <td>{bk.customer.uname}</td>
                  <td>₹ {bk.variant.price}</td>
                  <td>{bk.fromdate}</td>
                  <td>{bk.todate}</td>
                  {/* <td>{bk.status}</td> */}
                  <td>
                    <button
                      onClick={(e) => showDetails(bk.id)}
                      className='btn btn-primary btn-sm'
                    >
                      Details
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  )
}
