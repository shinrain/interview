#include "Logging.h"


Logging::Logging(std::string filename, std::string toStrandardOut){
    config = new Configurations();
    config->setAll(ConfigurationType::Filename,filename);
    config->setAll(ConfigurationType::Format, "%datetime [%level]: %log");
    config->setAll(ConfigurationType::ToStandardOutput,toStrandardOut);
    Loggers::setDefaultConfigurations(*config);
    Loggers::getLogger("testDefaultConf");
}
Logging* Logging::initLogger(std::string filename, std::string toStrandardOut){
	if(!instance){
		instance = new Logging(filename, toStrandardOut);
	}
	return instance;
}

void Logging::linfo(std::string info){
	CLOG(INFO, "testDefaultConf") << info;
} 

void Logging::vlog(int level, std::string info){
	CVLOG(level,"testDefaultConf") <<info;
}

