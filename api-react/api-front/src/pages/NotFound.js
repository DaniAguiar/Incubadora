import React from 'react';

import {Link} from "react-router-dom";

let NotFound = () =>
    <div className="div-pages">
        <h1>Ops, algo de errado não está certo...</h1>
        <form >
            <div>
                <Link to="/" className="btn btn-primary">Back</Link>
            </div>
        </form>
    </div>;

export default NotFound