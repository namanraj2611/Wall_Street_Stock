import AdminNav from './Adminnav'
import { useEffect, useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import axios from 'axios'
import { toast } from 'react-toastify'

const Bikes = () => {
  const [variants, setVariants] = useState([])
  const [data, setData] = useState([])
  const [filter, setFilter] = useState('All Bikes')
  const [edit, setEdit] = useState(false)
  const [bike, setBike] = useState({
    id: '',
    modelyear: '',
    varid: '',
  })
  const history = useHistory()
  useEffect(() => {
    axios.get('http://localhost:8080/api/variants').then((resp) => {
      setVariants(resp.data)
    })
    loadData()
  }, [])

  const handleInput = (e) => {
    setBike({ ...bike, [e.target.name]: e.target.value })
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log(bike)
    if (bike.id === '' || bike.modelyear === '' || bike.varid === '') {
      toast.error('Please provide required details')
    } else {
      axios
        .post('http://localhost:8080/api/bikes', bike)
        .then((resp) => {
          toast.success('Company saved successfully')
          setBike({
            id: '',
            modelyear: '',
            varid: '',
          })
          setEdit(false)
          loadData()
        })
        .catch((error) => {
          toast.error(error)
        })
    }
  }

  const handleFilter = (id) => {
    setFilter(id)
  }

  const handleEdit = (item) => {
    setEdit(true)
    setBike({
      id: item.id,
      modelyear: item.modelyear,
      varid: item.variant.id,
    })
  }

  const handleDelete = (id) => {
    const resp = window.confirm('Are you sure you want to Delete this Stocks ?')
    if (resp) {
      axios
        .delete('http://localhost:8080/api/bikes/' + id)
        .then((resp) => {
          toast.success(resp.data)
          loadData()
        })
        .catch((error) => {
          toast.error('Stocks already in bookings')
        })
    }
  }

  const loadData = () => {
    axios.get('http://localhost:8080/api/bikes').then((resp) => {
      setData(resp.data)
    })
  }
  return (
    <>
      <div className='content-wrapper p-2'>
        <div
          className='container-fluid shadow p-2 bg-white'
          style={{ minHeight: '88vh' }}
        >
          <div className='row'>
            <div className='col-sm-8'>
              <div className='form-inline float-right mt-1 mr-2'>
                <label className='mr-2'>Filter</label>
                <select
                  onChange={(e) => handleFilter(e.target.value)}
                  className='form-control form-control-sm'
                  style={{ width: 200 }}
                >
                  <option>All Stock</option>
                  <option>Available</option>
                  <option>Not Available</option>
                </select>
              </div>
              <h5
                className='p-2 mb-3'
                style={{ borderBottom: '2px solid green' }}
              >
                Stocks
              </h5>
              <table className='table table-bordered table-sm'>
                <thead>
                  <tr>
                    <th>Stock</th>
                    <th>Year enlisted</th>
                    <th>Categories</th>
                    <th>Status</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {data
                    .filter((val) => {
                      if (filter === 'All Stocks') return val
                      else return val.status === filter
                    })
                    .map((x, index) => (
                      <tr key={index}>
                        <td>{x.id}</td>
                        <td>{x.modelyear}</td>
                        <td>
                          {x.variant.title} - {x.variant.company.compname}
                        </td>
                        <td>{x.status}</td>
                        <td>
                          <button
                            className='btn btn-danger btn-sm'
                            onClick={(e) => handleDelete(x.id)}
                          >
                            Remove
                          </button>
                          <button
                            className='btn btn-primary btn-sm ml-2'
                            onClick={(e) => handleEdit(x)}
                          >
                            Edit
                          </button>
                        </td>
                      </tr>
                    ))}
                </tbody>
              </table>
            </div>
            <div className='col-sm-4'>
              <div className='Biked'>
                <div className='Biked-body'>
                  <h5>Stock Details</h5>
                  <form>
                    <div className='form-group'>
                      <label>Select Stock</label>
                      <select
                        required
                        className='form-control'
                        name='varid'
                        value={bike?.varid}
                        onChange={handleInput}
                      >
                        <option value>-- Select Category --</option>
                        {variants.map((x) => (
                          <option key={x.id} value={x.id}>
                            {x.title} - {x.company.compname}
                          </option>
                        ))}
                      </select>
                    </div>
                    <div className='form-group'>
                      <label>Stock Id</label>
                      <input
                        type='text'
                        disabled={edit}
                        required
                        className='form-control'
                        value={bike?.id}
                        onChange={handleInput}
                        name='id'
                      />
                    </div>
                    <div className='form-group'>
                      <label>Enlisted Year</label>
                      <input
                        type='text'
                        required
                        className='form-control'
                        value={bike?.modelyear}
                        onChange={handleInput}
                        name='modelyear'
                      />
                    </div>
                    <Link
                      to='/bikes'
                      className='btn btn-danger btn-sm float-right ml-2'
                    >
                      Cancel
                    </Link>
                    <input
                      type='submit'
                      onClick={handleSubmit}
                      className='btn btn-primary btn-sm float-right'
                      defaultValue='Save Bike'
                    />
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Bikes
