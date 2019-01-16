# Intrusion-Detection
Concept Used

My project implemented in SWING that contains the JFrameBuilder. (n/w concept include) . In addition to the new components, Swing makes three major improvements on the AWT.

Swing:

•	It doesn't rely on the runtime platform's native components. It's written entirely in Java, and creates its own components. This new       approach should solve the portability problem, since components don't inherit the weird behaviors from the runtime environment.
•	Because Swing is in complete control of the components, it's in control of the way components look on the screen, and gives you more       control of how our applications look.
•	Most Swing components are lightweight; this means that components are not dependent on native peers to render themselves. Instead, they   use simplified graphics primitives to paint themselves on the screen and can even allow portions to be transparent.

As this project is networking based then obviously the concept of NETWORKING comes which are explain below.

Socket Programming:
•	In order to initiate a TCP session, a server and a client are required. 
•	Firstly, a server is set up to listen at a given port. The server waits and does nothing until a client attempts to connect that port.     If everything goes fine, the connection is successful and both the server and client have an instance of the Socket class. From each       instance of this class, an input stream and an output stream can be obtained and all communication is done via these streams.
Modules & its description

a.	Packet Creation.
b.	Find authorized and unauthorized port.
c.	Constructing Inter-Domain Packet Filters.
d.	Receiving the valid packet.

Module-1: 	
	In this module, browse and select the source file and selected data is converted into fixed size of packets. The packet is send from source to detector.
  
Module-2: 	
The intrusion detection is defined as a mechanism for a WSN to detect the existence of inappropriate, incorrect, or anomalous moving attackers. In this module check whether the path is authorized or unauthorized. If path is authorized the packet is send to valid destination otherwise the packet will be deleted. According port no only we are going to find the path is authorized or Unauthorized.

Module-3: 	
If the packet is received from other than the port no it will be filtered and discarded. This filter only removes the unauthorized packets and authorized packets send to destination.

Module-4: 	
In this module, after filtering the invalid packets all the valid packets will reach the destination. Due to detector integrity of packet is maintained.
