document.addEventListener('DOMContentLoaded', () => {   
    const StudentForm = document.getElementById("StudentForm");   
    const studentTable = document     
    .getElementById("studentTable")     
    .getElementsByTagName("tbody")[0];    
    
    const apiBaseUrl = "http://localhost:9090/api/students";    
    
    function fetchStudents() {     
        fetch(apiBaseUrl)       
        .then((response) => response.json())       
        .then((data) => {         
            studentTable.innerHTML = "";         
            data.forEach((student) => {           
                const row = studentTable.insertRow();           
                row.innerHTML = `                         
                <td>${student.id}</td>                         
                <td>${student.firstName}</td>                         
                <td>${student.lastName}</td>                         
                <td>${student.email}</td>
                <td>${student.dept}</td>
                <td>${student.yoe}</td>                         
                <td>                             
                    <button onclick="editstudent(${student.id})">Edit</button>                             
                    <button onclick="deletestudent(${student.id})">Delete</button>                         
                </td>                     
                `;         
            });       
        });   
    }    
    StudentForm.addEventListener("submit", (e) => {     
        e.preventDefault();      
        const id = document.getElementById("studentId").value;     
        const firstName = document.getElementById("firstName").value;     
        const lastName = document.getElementById("lastName").value;     
        const email = document.getElementById("email").value;   
        const dept = document.getElementById("Dept").value;
        const yoe = document.getElementById("YOE").value;   
        
        const method = id ? "PUT" : "POST";     
        const url = id ? `${apiBaseUrl}/${id}` : apiBaseUrl;      
        
        fetch(url, {       
            method: method,       
            headers: {         
                "Content-Type": "application/json",       
            },       
            body: JSON.stringify({ firstName, lastName, email, dept, yoe}),     
        })       
        .then((response) => response.json())       
        .then(() => {         
            StudentForm.reset();         
            fetchStudents();       
        });   
    });    
    
    window.editstudent = function (id) {     
        fetch(`${apiBaseUrl}/${id}`)       
        .then((response) => response.json())       
        .then((student) => {         
            document.getElementById("studentId").value = student.id;         
            document.getElementById("firstName").value = student.firstName;         
            document.getElementById("lastName").value = student.lastName;         
            document.getElementById("email").value = student.email;
            document.getElementById("Dept").value = student.dept;
            document.getElementById("YOE").value = student.yoe;       
        });   
    };    
    
    window.deletestudent = function (id) {     
        fetch(`${apiBaseUrl}/${id}`, {       
            method: "DELETE",     
        }).then(() => fetchStudents());   
    };    
    fetchStudents(); 
});