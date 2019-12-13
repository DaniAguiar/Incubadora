import React, { Component } from "react";

import axios from "../../utils/httpClient"
import Field from "../../components/Field";
import { Link } from "react-router-dom";

class EditAccount extends Component {
    state = {
        account: {
            balance: "",
            accountLimit: "",
            maxLimit: ""
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
            .catch(({ response }) => {
                if (response.status === 404) {
                    this.props.history.push("/not-found")
                }
            })
    }

    retrieveAccountId = () =>
        this.props.match.params.id;

    handleChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({ account }) => ({
            account: {
                ...account,
                [field]: value
            }
        }))
    };

    handleSubmit = (event) => {
        event.preventDefault();

        axios.put(`/accounts/${this.retrieveAccountId()}`, this.state.account)
            .then(() => this.props.history.push("/accounts"))
            .catch(({ response }) => {
                if (response.status === 400) {
                    this.setState({
                        errors: response.data
                    })
                }
            })
    };

    render() {
        const { account, errors } = this.state;

        return <div className="div-pages">
            <h1 className="page-title">Alter Account</h1>

            <form onSubmit={this.handleSubmit}>
                {/* <Field name="balance"
                       label="Balance"
                       value={account.balance}
                       errors={errors["balance"]}
                       onChange={this.handleChange}/>

                <Field name="accountLimit"
                       label="Account Limit"
                       value={account.accountLimit}
                       errors={errors["accountLimit"]}
                       onChange={this.handleChange}/> */}

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
    }
}

export default EditAccount;