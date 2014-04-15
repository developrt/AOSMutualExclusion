AOSMutualExclusion
==================

Suzuki Kasami protocol
  This program implements Suzuki Kasami mutual exclusion protocol for distributed systems. This is a simulated verision that works on a limited number of nodes, but it can be extended to any number of nodes and any application requiring a Mutual Exclusion service by making use of cs-enter and cs-leave methods in Application.java 


1) Compile the source files on machines requiring mutual exclusion protocol
2) Open Config.txt, modify the contents of it as required. The first line signifies the number of nodes followed by lines each containing the host ip address and port to connect.
3) Make sure the same contents of Config.txt exist across all the hosts, and place it in the same location as source files.
4) On each host run Application.java with single argument nodeid. e.g.: "java Application 1" on a CLI
5) Execute the same on all machines in Config.txt
6) Once execution is completed, test using the command "java MutualExclusionTest"
7) This tests the program execution and returns the status of the test.
