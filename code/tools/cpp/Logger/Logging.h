#ifndef _LOGGING_H_
#define _LOGGING_H_

#include "easylogging++.h"
#include <cstring>

_INITIALIZE_EASYLOGGINGPP

using namespace easyloggingpp;

class Logging{

public:
	static Logging* initLogger(std::string filename = "test.log", std::string toStandardOut = "true");	// Static creator of Logger	
	void linfo(std::string);
	void vlog(int level, std::string info);
private:
	Configurations* config;	// COnfiguration member from easylogging++
	static Logging* instance;
	Logging(std::string filename, std::string toStrandardOut);
	//Logging(std::string filename , std::string toStandardOut);		// private constructor to implement singleton
	Logging(Logging const&){}; 
	Logging& operator=(Logging const&){};
};


#endif 
