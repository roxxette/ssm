INCDIR = $(SSMWORKPATH)/inc/
LIBDIR = $(SSMWORKPATH)/lib/

INCLUDE = $(INCDIR)util.h \
	$(INCDIR)errlog.h \
	$(INCDIR)hsmcmd.h \
	$(INCDIR)bntcmd.h \
	$(INCDIR)bntfmt.h

HSMLIB = $(LIBDIR)/libhsmcmd.a
#HSMDLL = $(LIBDIR)/libhsmcmd.so
#HSMDLLVER = $(LIBDIR)/libhsmcmd.so.1.0.0

CPP = g++
CPPFLAG = -c -g -I$(INCDIR)

OBJ = hsmcmd.o \
	bntcmd.o \
	bntfmt.o

#project: $(HSMDLL) rmobj

#$(HSMDLL):$(OBJ)
#	g++ -g -shared -o $(HSMDLL) $(OBJ) -lc

project: $(HSMLIB) rmobj

$(HSMLIB):$(OBJ)
	ar -r $(HSMLIB) $(OBJ)

hsmcmd.o:hsmcmd.cpp $(INCLUDE)
	$(CPP) -o hsmcmd.o $(CPPFLAG) hsmcmd.cpp

bntcmd.o:bntcmd.cpp $(INCLUDE)
	$(CPP) -o bntcmd.o $(CPPFLAG) bntcmd.cpp

bntfmt.o:bntfmt.cpp $(INCLUDE)
	$(CPP) -o bntfmt.o $(CPPFLAG) bntfmt.cpp

#lnso:
#	ln -s $(HSMDLLVER) $(HSMDLL)

rmobj:
	rm -f *.o *old*
