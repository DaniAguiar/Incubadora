import React, { Component } from "react";

import axios from "../../utils/httpClient"
import Field from "../../components/Field";
import { Link } from "react-router-dom";

class EditPerson extends Component {
    state = {
        person: {
            name: ""
        },
        errors: {}
    };

    componentDidMount() {
        axios.get(`/people/${this.retrievePersonId()}`)
            .then(({ data }) => {
                this.setState({
                    person: data
                })
            })
            .catch(({ response }) => {
                if (response.status === 404) {
                    this.props.history.push("/not-found")
                }
            })
    }

    retrievePersonId = () =>
        this.props.match.params.id;

    handleChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({ person }) => ({
            person: {
                ...person,
                [field]: value
            }
        }))
    };

    handleSubmit = (event) => {
        event.preventDefault();

        axios.put(`/people/${this.retrievePersonId()}`, this.state.person)
            .then(() => this.props.history.push("/people"))
            .catch(({ response }) => {
                if (response.status === 400) {
                    this.setState({
                        errors: response.data
                    })
                }
            })
    };

    render() {
        const { person, errors } = this.state;

        return <div className="div-pages">
            <h1 className="page-title">Alter Person</h1>

            <form onSubmit={this.handleSubmit}>
                <Field name="name"
                       label="Name"
                       value={person.name}
                       errors={errors["name"]}
                       onChange={this.handleChange}/>

                <div className="button-center">
                    <Link to="/people" className="btn btn-primary">Back</Link>&nbsp;
                    <button type="submit" className="btn btn-success">Save</button>
                </div>
            </form>
        </div>
    }
}

export default EditPerson;