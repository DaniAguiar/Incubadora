import React, { Component } from "react";
import axios from "../../utils/httpClient";

import {Link} from 'react-router-dom';

class ListAccount extends Component{
    state={
        accounts: []
    };

    componentDidMount(){
        this.retrieveAccounts();
    }

    handleRemove = (id) => {
        axios.delete(`/accounts/${id}`)
            .then(() => this.retrieveAccounts())
    };

    retrieveAccounts(){
        axios.get("/accounts")
            .then(({ data }) => 
                this.setState({
                    accounts: data
                })
            )
    }

    render(){
        return <div className="div-pages">
            <h1 className="page-title">Accounts List</h1>

            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Balance</th>
                        <th>Account Limit</th>
                        <th>Max Limit</th>
                        <th>Id Person</th>
                        <th>Date of Creation</th>
                        <th>Date of Update</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.accounts.map(account => <tr key={account.id}>
                        <td>{account.id}</td>
                        <td>{account.balance}</td>
                        <td>{account.accountLimit}</td>
                        <td>{account.maxLimit}</td>
                        <td>{account.person.id}</td>
                        <td>{account.createdAt}</td>
                        <td>{account.updatedAt}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => this.handleRemove(account.id)}>Delete</button>&nbsp;
                            <Link to={`/accounts/edit/${account.id}`} className="btn btn=sm btn-primary">Alter</Link>&nbsp;
                            <Link to={`/accounts/opitions/${account.id}`} className="btn btn=sm btn-info">Options</Link>
                        </td>
                    </tr>)}
                </tbody>
            </table>
            <Link to="/" className="btn btn-primary">Home</Link>
            <div className="float-right">
                <Link to="/accounts/new" className="btn btn-primary">New Account</Link>
            </div>
        </div>;
    }
}

export default ListAccount