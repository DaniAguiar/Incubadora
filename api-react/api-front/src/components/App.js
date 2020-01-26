import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import NotFound from "../pages/NotFound"
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css'

import ListAccount from "../pages/account/ListAccount";
import NewAccount from "../pages/account/NewAccount";
import EditAccount from "../pages/account/EditAccount";
import OpitionsAccount from "../pages/account/OpitionsAccount";

import NewPerson from "../pages/person/NewPerson";
import ListPerson from "../pages/person/ListPerson";
import EditPerson from "../pages/person/EditPerson";

import Home from "../pages/Home"

const App = () =>
  <div className="background">
        <BrowserRouter>
            <Switch>
                <Route path={["/"]} exact component={Home}/>
                
                <Route path={["/accounts"]} exact component={ListAccount}/>
                <Route path="/accounts/new" exact component={NewAccount}/>
                <Route path="/accounts/edit/:id" exact component={EditAccount}/>
                <Route path="/accounts/opitions/:id" exact component={OpitionsAccount}/>

                <Route path={["/people"]} exact component={ListPerson}/>
                <Route path="/people/new" exact component={NewPerson}/>
                <Route path="/people/edit/:id" exact component={EditPerson}/>

                <Route path="*" component={NotFound}/>
            </Switch>
        </BrowserRouter>
    </div>;

export default App;
