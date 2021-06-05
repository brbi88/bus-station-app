import React from "react";
import {Table, Button, Form, ButtonGroup} from "react-bootstrap";
import AutobuskaAxios from "../../apis/AutobuskaAxios";

class Linije extends React.Component {
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
          prevoznici: [],
          search: {destinacija: "", prevoznikId: -1, maxCena: 0.0},
          pageNo: 0,
          totalPages: 1,
      };
    }

    componentDidMount() {
        this.getData();
    }

    async getData() {
        await this.getPrevoznici();
        await this.getLinije(0);
    }

    async getLinije(page) {
        let config = {params: {
            pageNo: page
        }};

        if (this.state.search.destinacija != "") {
            config.params.destinacija = this.state.search.destinacija;
        }

        if (this.state.search.prevoznikId != -1) {
            config.params.prevoznikId = this.state.search.prevoznikId;
        }

        if (this.state.search.maxCena != 0.0) {
            config.params.maxCena = this.state.search.maxCena;
        }

        try {
            let result = await AutobuskaAxios.get("/linije", config);
            if (result && result.status === 200) {
                this.setState({
                    pageNo: page,
                    linije: result.data,
                    totalPages: result.headers["total-pages"],
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
            console.log(error);
            alert("Nije uspelo dobavljanje.");
        }
    }

    goToEdit(linijaId) {
        this.props.history.push('/linije/edit/' + linijaId);
    }

    async doAdd() {
        try {
            await AutobuskaAxios.post("/linije/", this.state.linija);

            let linija = {
                brMesta: 0,
                cenaKarte: 0.0,
                vrPolaska: "",
                destinacija: "",
                prevoznikId: -1,
            };
            this.setState({linija: linija});

            this.getLinije(0);
        }catch (error) {
            alert("Nije uspelo dodavanje.");
        }
    }

    async doDelete(linijaId) {
        try {
            await AutobuskaAxios.delete("/linije/" + linijaId);
            this.getLinije(0);
        }catch (error) {
            alert("Nije uspelo brisanje.");
        }
    }

    addValueInputChange(event) {
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let linija = this.state.linija;
        linija[name] = value;

        this.setState({linija: linija});
    }

    searchValueInputChange(event) {
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let search = this.state.search;
        search[name] = value;

        this.setState({search: search});
    }

    doSearch() {
        this.getLinije(0);
    }

    async rezervacija(id) {
        try {
            await AutobuskaAxios.post(`/linije/${id}/rezervacija`);
            this.getLinije(0);
        }catch (error) {
            alert("Nije moguce izvrsiti rezervaciju.");
        }
    }

    render() {
        return (
            <div>
                <h1>Linije</h1>
                <Form>
                    <Form.Group>
                        <Form.Label>Broj mesta</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChange(event)}
                        name="brMesta"
                        value={this.state.linija.brMesta}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Cena karte</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChange(event)}
                        name="cenaKarte"
                        value={this.state.linija.cenaKarte}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Destinacija</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChange(event)}
                        name="destinacija"
                        value={this.state.linija.destinacija}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Vreme polaska</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChange(event)}
                        name="vrPolaska"
                        value={this.state.linija.vrPolaska}
                        as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Prevoznik</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChange(event)}
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
                    <Button variant="primary" onClick={() => this.doAdd()}>
                        Dodaj
                    </Button>
                </Form>

                <Form style={{marginTop:35}}>
                    <Form.Group>
                        <Form.Label>Destinacija</Form.Label>
                        <Form.Control
                        value={this.state.search.destinacija}
                        name="destinacija"
                        as="input"
                        onChange={(e) => this.searchValueInputChange(e)}>
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Prevoznik</Form.Label>
                        <Form.Control
                        onChange={(event) => this.searchValueInputChange(event)}
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
                    <Form.Group>
                        <Form.Label>Maksimalna cena</Form.Label>
                        <Form.Control
                        value={this.state.search.maxCena}
                        name="maxCena"
                        as="input"
                        onChange={(e) => this.searchValueInputChange(e)}>
                        </Form.Control>
                    </Form.Group>
                    <Button onClick={() => this.doSearch()}>Trazi</Button>
                </Form>

                <ButtonGroup style={{marginTop:25}}>
                    <Button
                    disabled={this.state.pageNo==0} onClick={()=>this.getLinije(this.state.pageNo-1)}>
                        Previous
                    </Button>
                    <Button
                    disabled={this.state.pageNo==this.state.totalPages-1} onClick={()=>this.getLinije(this.state.pageNo+1)}>
                        Next
                    </Button>
                </ButtonGroup>

                <Table bordered striped style={{marginTop:5}}>
                    <thead className="thead-dark">
                        <tr>
                            <th>Naziv prevoznika</th>
                            <th>Destinacija</th>
                            <th>Broj mesta</th>
                            <th>Vreme polaska</th>
                            <th>Cena karte</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.linije.map((linija) => {
                            return (
                                <tr key={linija.id}>
                                    <td>{linija.prevoznikNaziv}</td>
                                    <td>{linija.destinacija}</td>
                                    <td>{linija.brMesta}</td>
                                    <td>{linija.vrPolaska}</td>
                                    <td>{linija.cenaKarte}</td>
                                    <td>
                                        <Button
                                        disabled={linija.rezervacija === 3}
                                        variant="info"
                                        onClick={() => this.rezervacija(linija.id)}>
                                            Rezervisi
                                        </Button>

                                        <Button
                                        variant="warning"
                                        onClick={() => this.goToEdit(linija.id)}
                                        style={{marginLeft:5}}>
                                            Izmeni
                                        </Button>

                                        <Button
                                        variant="danger"
                                        onClick={() => this.doDelete(linija.id)}
                                        style={{marginLeft:5}}>
                                            Obrisi
                                        </Button>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Linije;