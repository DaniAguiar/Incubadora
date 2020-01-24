import React, { Component } from 'react'

import axios from '../../utils/httpClient'
import Field from '../../components/Field'
import {Link} from 'react-router-dom'

class OpitionsAccount extends Component{
    state = {
        account: {
            balance: "",
            accountLimit: "",
            maxLimit: "",
            valAct: ""
        },
        errors: {}
    };

    componentDidMount() {
        axios.get(`/accounts/${this.retrieveAccountId()}`)
            .then(({ data }) => {
                this.setState({
                    account: data
                })
            })
    }

    retrieveAccountId = () =>
        this.props.match.params.id;

    handleChange = e => {
        
        const{account} = this.state;
        
        this.setState({account: {...account, valAct: e.target.value}})
    };

    
    handleAmount = async e => {
        e.preventDefault();
        
        const option = e.target.value;

        const data = {
            "amount": this.state.account.valAct
        }

        if(option === 'w') {
            await axios.post(`/accounts/withdraws/${this.retrieveAccountId()}`, data)
                    .then(() => this.props.history.push("/accounts"))

        } else {
            await axios.post(`/accounts/deposits/${this.retrieveAccountId()}`, data)
                    .then(() => this.props.history.push("/accounts"))
        }

        axios.get(`/accounts/${this.retrieveAccountId()}`)
            .then(({ data }) => {
                this.setState({
                    account: data
                })
            })
    };

    render(){

        const { account, errors } = this.state
        
        return <div className="div-pages">
            <h1 className="page-title">Account Opition</h1>

            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Balance</th>
                        <th>Account Limit</th>
                        <th>Max Limit</th>
                        <th>Date of Creation</th>
                        <th>Date of Update</th>
                    </tr>
                </thead>
                <tbody>
                    <tr key={account.id}>
                        <td>{account.id}</td>
                        <td>{account.balance}</td>
                        <td>{account.accountLimit}</td>
                        <td>{account.maxLimit}</td>
                        <td>{account.createdAt}</td>
                        <td>{account.updatedAt}</td>
                    </tr>
                </tbody>
            </table>

            <form>
                <Field name="amount"
                    label="Amount"
                    errors={errors["account.valAct"]}
                    onChange={this.handleChange}
                />
                
                <div className="button-center">
                    <button className="btn btn-info" type="submit" value="w" 
                        onClick={this.handleAmount}>Withdraw</button>&nbsp;
                    <button className="btn btn-info" type="submit" value="d"  
                        onClick={this.handleAmount}>Deposit</button>
                </div>
                
            </form>

            <div className="float-right">
                <Link to="/accounts" className="btn btn-primary">Back</Link>
            </div>
        </div>;
    }

}

export default OpitionsAccount