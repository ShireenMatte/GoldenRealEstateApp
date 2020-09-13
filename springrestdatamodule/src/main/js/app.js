'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/employees'}).done(response => {
			this.setState({employees: response.entity._embedded.employees});
		});
	}

	render() { // <3>
		return (
			<EmployeeList employees={this.state.employees}/>
			
		)
	}
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{

	render() {
		const employees = this.props.employees.map(employee =>
			<Employee key={employee._links.self.href} employee={employee}/>
		);
		return (
			<table class="table table-grey table-bordered table-striped">
				<tbody>
					<tr>
							<th>Category</th>
							<th>Description</th>
							<th>Status</th>
	                        <th>Assigned</th>
					</tr>
					{employees}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{

setEditing(value) {
  if(typeof value !== 'boolean') { throw " This value must either be true or false"}
  this.setState({
    editing: value
  })
}
	render() {
		return (
			<tr>
				<td>{this.props.employee.category}</td>
				<td>{this.props.employee.description}</td>
				<td>{this.props.employee.status}</td>
				<td>{this.props.employee.assigned}</td>
			</tr>
			
		)
	}
}

// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
