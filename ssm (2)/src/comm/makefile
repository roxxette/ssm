INCDIR = $(SSMWORKPATH)/inc/
LIBDIR = $(SSMWORKPATH)/lib/

INCLUDE = $(INCDIR)util.h \
	$(INCDIR)errlog.h \
	$(INCDIR)commTCPIP.h \
	$(INCDIR)commSerialPort.h
 
COMMTCPIPLIB = $(LIBDIR)/libcommTCPIP.a
COMMSERIALPORTLIB = $(LIBDIR)/libcommSERIALPORT.a

CPP = g++32
CPPFLAG = -g -c -I$(INCDIR)

OBJ = commTCPIP.o commSerialPort.o

project: $(COMMTCPIPLIB) ${COMMSERIALPORTLIB} rmobj

${COMMTCPIPLIB}:commTCPIP.o
	ar -r $(COMMTCPIPLIB) commTCPIP.o

${COMMSERIALPORTLIB}:commSerialPort.o
	ar -r $(COMMSERIALPORTLIB) commSerialPort.o
	
commTCPIP.o:commTCPIP.cpp $(INCLUDE)
	$(CPP) -o commTCPIP.o $(CPPFLAG) commTCPIP.cpp

commSerialPort.o:commSerialPort.cpp $(INCLUDE)
	$(CPP) -o commSerialPort.o $(CPPFLAG) commSerialPort.cpp
	
rmobj:
	rm -f *.o *old*
