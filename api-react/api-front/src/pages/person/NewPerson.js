import React, { Component } from 'react';
import axios from '../../utils/httpClient';

import Field from '../../components/Field'
import {Link} from 'react-router-dom';

class NewPerson extends Component{
    state = {
        person: {
            name: ""
        },
        errors: {},
        globalError: ""
    };

    handleChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({person}) => ({
            person: {
                ...person,
                [field]: value
            }
        }))
    };

    handleSubmit = (event) => {
        axios.post("/people", this.state.person)
            .then(() => this.props.history.push("/people"))
            .catch(({response}) => {
                if(response.status === 400){
                    this.state({
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
        const{ person, errors, globalError } = this.state;
        
        return(
            <div className="div-pages">
                <h1 className="page-title">New Person</h1>

                {globalError ? <div className="alert alert-danger">
                    {globalError}
                </div>: <></>}

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
        );
    }
}

export default NewPerson;