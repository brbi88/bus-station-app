import React from "react";
import {Button, Form} from "react-bootstrap";
import AutobuskaAxios from "../../apis/AutobuskaAxios";

class IzmeniLinije extends React.Component {
    constructor(props) {
        super(props);

      let linija = {
          brMesta: 0,
          cenaKarte: 0.0,
          vrPolaska: "",
          destinacija: "",
          prevoznikId: -1,
      };

      this.state = {
          linija: linija,
          linije: [],
          prevoznici: []
      };
    }

    componentDidMount() {
        this.getData();
    }

    async getData() {
        await this.getPrevoznici();
        await this.getLinije();
    }

    async getLinije() {

        try {
            let result = await AutobuskaAxios.get("/linije/" + this.props.match.params.id);
            if (result && result.status === 200) {
                this.setState({
                    linije: result.data
                });
            }
        }catch (error) {
            alert("Nije uspelo dobavljanje.");
        }
    }

    async getPrevoznici() {
        try {
            let result = await AutobuskaAxios.get("/prevoznici");
            if (result && result.status === 200) {
                this.setState({
                    prevoznici: result.data,
                });
            }
        }catch (error) {
            alert("Nije uspelo dobavljanje.");
        }
    }

    async doEdit() {
        try {
            await AutobuskaAxios.put("/linije/" + this.props.match.params.id, this.state.linija);
            this.props.history.push("/linije");
        }catch (error) {
            alert("Nije uspelo cuvanje.");
        }
    }

    valueInputChange(event) {
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let linija = this.state.linija;
        linija[name] = value;

        this.setState({linija: linija});
    }

    render() {
        return (
            <div>
                <h1>Linije</h1>
                <Form>
                    <Form.Group>
                        <Form.Label>Broj mesta</Form.Label>
                        <Form.Control
                        onChange={(event) => this.valueInputChange(event)}
                        name="brMesta"
                        value={this.state.linija.brMesta}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Cena karte</Form.Label>
                        <Form.Control
                        onChange={(event) => this.valueInputChange(event)}
                        name="cenaKarte"
                        value={this.state.linija.cenaKarte}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Destinacija</Form.Label>
                        <Form.Control
                        onChange={(event) => this.valueInputChange(event)}
                        name="destinacija"
                        value={this.state.linija.destinacija}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Vreme polaska</Form.Label>
                        <Form.Control
                        onChange={(event) => this.valueInputChange(event)}
                        name="vrPolaska"
                        value={this.state.linija.vrPolaska}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Prevoznik</Form.Label>
                        <Form.Control
                        onChange={(event) => this.valueInputChange(event)}
                        name="prevoznikId"
                        value={this.state.linija.prevoznikId}
                        as="select">
                            <option value={-1}></option>
                            {this.state.prevoznici.map((prevoznik) => {
                                return (
                                    <option value={prevoznik.id} key={prevoznik.id}>
                                        {prevoznik.naziv}
                                    </option>
                                );
                            })}
                        </Form.Control>
                    </Form.Group>
                    <Button variant="primary" onClick={() => this.doEdit()}>
                        Izmeni
                    </Button>
                </Form>
                
            </div>
        );
    }
}

export default IzmeniLinije;
