import React, { Component } from 'react';
import Select from "react-select";
import Axios from 'axios';


let axiosDefaults = require('axios/lib/defaults');
axiosDefaults.baseURL = 'http://localhost:8080/';

class App extends Component {
  
  constructor(){
    super();
    this.state={
      tickets : null,
      description : null,
      cancelledDescription : null,
      comments : null,
      statusValue : null,
      cancelledReasonValue : null
    }

    this.handleSubmit = this.handleSubmit.bind(this); 
    
  }

  async handleSubmit(event){
        let paramValue={};
        paramValue.createdBy = 'Ajira';
        paramValue.severity = 0;
        paramValue.status = this.state.statusValue;
        paramValue.cancelledReason = this.state.cancelledReasonValue;
        paramValue.cancelledDescription = this.state.cancelledDescription;
        paramValue.description = this.state.description;
        paramValue.comments = this.state.comments;
        JSON.stringify(paramValue);
        let response = await Axios.post('/ticket-management-system/api/ticket/', { param: paramValue } ,
        {headers: {
          "Content-Type": "application/json"
      }});
        this.setState({ ...this.state, tickets: response.data })
        window.alert('Success');
        }

  handleCancelledDescription = e =>{
    this.setState({...this.setState, cancelledDescription : e.target.value})
  }

  handleDescriptionChange= e =>{
    this.setState({...this.state, description : e.target.value})
  }
  
  handleStatusChange =(e)=>{
    this.setState({...this.state, statusValue:e.label})
    console.log(this.state)
  }

  handleCancelReasonChange = e =>{
    this.setState({...this.state, cancelledReasonValue : e.label})
  }

  handleCommentsChange = e =>{
    this.setState({...this.state, comments : e.target.value})
  }
  render(){
    const status = [
      { label: "COMPLETED", value: 0 },
      { label: "CANCELLED", value: 1 }
    ];
    const cancelledReason = [
      { label: "ENDUSER", value: 0 },
      { label: "OTHERS", value: 1 }
    ];
   return (
    <div>
      <h2 style={{textAlign:"center", color:"Blue"}}>Ticket Management System</h2>
    <div style={{display :"table-caption"}}>
      <label aria-required={true}>
        Created By:
        <input required type="text" defaultValue={'Ajira'} />
      </label>
      <label>
        Description:
        <input required type="text" value={this.state.description} onChange={this.handleDescriptionChange} />
      </label>
      <label aria-required={true}>
        Severity:
        <input required type="text" defaultValue={'0'}  />
      </label>
      {this.state.statusValue === 'CANCELLED' && this.state.cancelledReasonValue === 'OTHERS'? <label aria-required={true}>
        CancelledDescription:
        <input required type="text" value={this.state.cancelledDescription} onChange={this.handleCancelledDescription} />
      </label>:null}
      {this.state.statusValue === 'COMPLETED'?<label aria-required={true}>
        Comments:
        <input required type="text" value={this.state.comments} onChange={this.handleCommentsChange} />
      </label>:null }
    </div>
    <div style={{width:170}}>
    <label aria-required={true}>
        Status:
        <Select style={{width:100}} options={ status } value={status[this.state.statusValue]} onChange={this.handleStatusChange}/>
        </label>
        {this.state.statusValue==='CANCELLED' ?<label aria-required={true}>
         CancelledReason:
        <Select style={{width:100}} options={ cancelledReason } value={cancelledReason[this.state.cancelledReasonValue]} onChange={this.handleCancelReasonChange}/>
        </label>: null}
        </div>  
      <div style={{width:500, marginLeft:170}}>
        <button style={{color: 'blue', backgroundColor: 'orange'}} onClick={this.handleSubmit} > Submit</button>
    </div>
    </div>
  );
}
}

export default App;
