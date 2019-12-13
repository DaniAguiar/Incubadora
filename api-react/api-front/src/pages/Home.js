import React from 'react'
import '../components/App.css'

import {Link} from "react-router-dom";

let Home = () =>

        <div className="div-home">
            <h1 className="page-title">Welcome to my Application</h1>
            <h2 className="page-subtitle">Bank Accounts Manager</h2>
            <form className="form">
                <div>
                    <Link to="/accounts" className="btn btn-primary">Manage Accounts</Link>
                </div>
            </form>
        </div>;

export default Home