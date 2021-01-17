import React, { Component } from 'react';
import {Button, ButtonGroup} from 'reactstrap';
import { Link } from 'react-router-dom';

class Users extends Component {
  state = {
    records: [],
    name: '',
    city: ''
  };

 componentDidMount(){
    console.log("componentDidMount");
    fetch("/v1/employees")
    .then(response => response.json())
    .then(data => this.setState({records: data}))
  }

  handleDelete = (record) => {
    console.log("handle delete.."+record.id);
    
    //delete
    fetch("/v1/employees/"+record.id,{
      method: "DELETE",
      headers: { 
        "Content-type": "application/json; charset=UTF-8"
      } 
    }
    ).then(response => response.json())
    .then(data => this.setState({records: data}))
  }

   render(){
    return <React.Fragment>
      <div>
        <Button color="success" tag={Link} to="/users/new">Add User</Button>
      </div>
      <div>
      <table className="table"> 
        <thead>
        <tr>
          <th>Name</th>
          <th>City</th>
        </tr>
        </thead>
        <tbody>
        {this.state.records.map( record => (
            <tr key={record.id}>
              <td>{record.name}</td>
              <td>{record.city}</td>
              <td>
               <ButtonGroup> 
                <Button size="sm" color="primary" tag={Link} to={"/users/"+record.id}>Edit</Button>
                <Button size="sm" color="danger" onClick={()=> this.handleDelete(record)}>Delete</Button>
                </ButtonGroup>
              </td>
            </tr>
          ))}
        </tbody>        
      </table>
      </div>
    </React.Fragment>

  }
}

export default Users;