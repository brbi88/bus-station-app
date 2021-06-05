import React from 'react';
import ReactDOM from 'react-dom';
import {Route, Link, HashRouter as Router, Switch} from 'react-router-dom';
import {Container, Button, Navbar, Nav} from "react-bootstrap";
import Login from './components/login/Login';
import Home from './components/Home';
import Linije from './components/linije/Linije';
import IzmeniLinije from './components/linije/IzmeniLinije';
import NotFound from './components/NotFound';
import { logout } from './services/auth';

class App extends React.Component {

  render() {
    return (
      <div style={{
        backgroundImage: `url(${process.env.PUBLIC_URL + '/jwt.jpg'})`,
        backgroundPosition: 'center',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
    width: '100vw',
    height: '100vh'
      }}>
        <div>
          <Router>
            <Navbar expand bg="dark" variant="dark">
              <Navbar.Brand as={Link} to="/"><img
              src="/bus.jpg"
              width="60"
              height="30"
              className="d-inline-block align-top"
              alt="React Bootstrap logo"
              /></Navbar.Brand>
              <Nav className="mr-auto">
                <Nav.Link as={Link} to="/linije">Linije</Nav.Link>
              </Nav>
                {window.localStorage['jwt'] ?
                <Button onClick= {() =>logout()}>Logout</Button> :
                <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                }
            </Navbar>

            <Container style={{marginTop: 25}}>
              <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/linije" component={Linije}/>      
                <Route exact path="/linije/edit/:id" component={IzmeniLinije}/>
                <Route exact path="/login" component={Login}/>
                <Route exact path={NotFound}/>
              </Switch>
            </Container>
          </Router>
        </div>
      </div>
    );
  }
}

ReactDOM.render(
    <App/>,
  document.querySelector("#root")
);

