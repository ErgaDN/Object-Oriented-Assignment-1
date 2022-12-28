# Object-Oriented-Assignment-1

In software design and engineering, the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

In our code, we organized a group of recipients of updates on the condition of UndoableStringBuilder and send all updates to it in real time. 
In the GroupAdmin class, that implements the Sender interface, describes the sender of the updates. The GroupAdmin class contains the state pool (UdoableStringBuilder) and a pool Customers who should receive updates on any changes made to the database.
We have added actions to update the customer list and to update the text that the customers are directed to.
We added the test class that checks the correctness of the operations.
