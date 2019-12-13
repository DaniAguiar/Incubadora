import React from 'react';

const Field = ({ label, name, value, errors, onChange}) =>
    <div className="form-group">
        <label htmlFor={name}>{label}</label>
        <input type="text"
                name={name}
                className="form-control"
                value={value}
                onChange={onChange}
                required="required"/><span class="required">*</span>

    </div>;

    export default Field