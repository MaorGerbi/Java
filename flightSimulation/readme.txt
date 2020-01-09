I want to write an application that simulates the take-off and landing of aircraft at an airport.
The system will consist of the following elements:
- Airport initialized with name, and several routes and includes the following methods:
- depart: The method accepts the flight number requesting to take off and returns a route number
Free from which you can take off. In case there is no available route the method will suspend the applicant until
Which will clear a route.
- land: The method obtains the flight number requesting to land and returns a free route number
Where you can land. In case there is no vacancy the method will suspend the applicant until it is vacated
Route.
- freeRunway: A method used to release a route used for take-off or landing.
The method receives the flight number and the vacated route number.