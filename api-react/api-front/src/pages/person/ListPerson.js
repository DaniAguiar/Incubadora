import React, { Component } from "react";
import axios from "../../utils/httpClient";

import {Link} from "react-router-dom";

class ListPerson extends Component{
    state={
        people: []
    };

    componentDidMount(){
        this.retrievePeople();
    }

    handleRemove = (id) => {
        axios.delete(`/people/${id}`)
            .then(() => this.retrievePeople())
    };

    retrievePeople(){
        axios.get("/people")
            .then(({ data }) => 
                this.setState({
                    people: data
                })
            )
    };

    render(){
        return <div className="div-pages">
            <h1 className="page-title">People List</h1>

            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Date of Creation</th>
                        <th>Date of Update</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.people.map(person => <tr key={person.id}>
                        <td>{person.id}</td>
                        <td>{person.name}</td>
                        <td>{person.createdAt}</td>
                        <td>{person.updatedAt}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => this.handleRemove(person.id)}>Delete</button>&nbsp;
                            <Link to={`/people/edit/${person.id}`} className="btn btn=sm btn-primary">Alter</Link>&nbsp;
                        </td>
                    </tr>)}
                </tbody>
            </table>
            <Link to="/" className="btn btn-primary">Home</Link>
            <div className="float-right">
                <Link to="/people/new" className="btn btn-primary">New Person</Link>
            </div>
        </div>;
        
    }
}

export default ListPerson;