import React, {Component} from 'react';
import axios from "../../utils/httpClient";

import Field from "../../components/Field";
import {Link} from "react-router-dom";

class NewAccount extends Component{
    state = {
        account: {
            balance: "",
            accountLimit: "",
            maxLimit: ""
        },
        errors: {},
        globalError: ""
    };

    handleChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({account}) => ({
            account: {
                ...account,
                [field]: value
            }
        }))
    };

    handleSubmit = (event) => {
        axios.post("/accounts", this.state.account)
            .then(() => this.props.history.push("/accounts"))
            .catch(({response}) => {
                if(response.status === 400){
                    this.setState({
                        errors: response.data
                    })
                }

                this.setState({
                    globalError: response.data.message
                })
            });

            event.preventDefault();
    };

    render(){
        const { account, errors, globalError } = this.state;
        return (
            <div className="div-pages">
                <h1 className="page-title">New Account</h1>

                {globalError ? <div className="alert alert-danger">
                    {globalError}
                </div> : <></>}

                <form onSubmit={this.handleSubmit}>
                    <Field name="balance"
                           label="Balance"
                           value={account.balance}
                           errors={errors["balance"]}
                           onChange={this.handleChange}/>

                    <Field name="accountLimit"
                           label="Account Limit"
                           value={account.accountLimit}
                           errors={errors["accountLimit"]}
                           onChange={this.handleChange}/>

                    <Field name="maxLimit"
                           label="Max Limit"
                           value={account.maxLimit}
                           errors={errors["maxLimit"]}
                           onChange={this.handleChange}/>

                    <div className="button-center">
                        <Link to="/accounts" className="btn btn-primary">Back</Link>&nbsp;
                        <button type="submit" className="btn btn-success">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default NewAccount;