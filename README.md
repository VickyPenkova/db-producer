# db-producer Micro service
First Run https://github.com/VickyPenkova/aureka-server project
Then Run the db-producer

Testing the REST API:
NOTE: When creating enteties using the API, JSON objects must have the all the non nullable fields declared in the Java class entities.
1. Create Doctor using the endpoint `http://localhost:8082/api/doctor/add`
Example:
{
	"username" : "7324072",
	"name" : "sveti",
	"password": "sveti",
	"medicalSpeciality": "dentist",
	"gp": 1,
	"roles": "DOCTOR"
}

2. Create patient using the endpoint `http://localhost:8082/api/patient/add`, with assigned doctor gp, who's been already saved in the db
Example:
{
  "username": "764574",
	"password": "anotherPatient",
	"name": "anotherPatient",
	"healthInsuranceDate": "2019-12-29T12:19:49.095+0000",
	"healthInsured": 1,
	"doctorGp": {
		"id": 1,
    "username": "7324072",
    "name": "sveti",
    "password": "sveti",
    "medicalSpeciality": "dentist",
    "roles": "DOCTOR",
    "active": 1,
    "gp": true
	},
	"roles": "PATIENT"
}

3. Create appointment using the endpoint `http://localhost:8082/api/appointment/add`
Example:
{
	"dateOfAppointment": "2021-01-29T12:19:49.095+0000",
	"diagnosis": "Sick",
	"doctor":{
      "id": 1,
      "username": "7324072",
      "name": "sveti",
      "password": "sveti",
      "medicalSpeciality": "dentist",
      "roles": "DOCTOR",
	    "patients": [
	        {
	            "username": "764574",
              "password": "anotherPatient",
              "name": "anotherPatient",
              "healthInsuranceDate": "2019-12-29T12:19:49.095+0000",
              "healthInsured": 1,
	            "active": 1
	        }
	    ]
    },
	"patient":{
    "id": 1,
    "username": "764574",
    "password": "anotherPatient",
    "name": "anotherPatient",
    "healthInsuranceDate": "2019-12-29T12:19:49.095+0000",
    "healthInsured": 1
	}
}
4. Call any of the REST API endpoints
etc.
