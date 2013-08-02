// Demonstrates setting default configruations for existing and future loggers

#include "../easylogging++.h"

_INITIALIZE_EASYLOGGINGPP

using namespace easyloggingpp;

void run(void) {
    Configurations c;
    c.setAll(ConfigurationType::Filename,"logs/test.log");
    c.setAll(ConfigurationType::Format, "%datetime [%level]: %log");
    c.setAll(ConfigurationType::ToStandardOutput,"false");
    Loggers::setDefaultConfigurations(c);
    Loggers::getLogger("testDefaultConf");
    
    // Now setting default and also resetting existing loggers
    CVLOG(1,"testDefaultConf") <<"Logging using level = 1";
	LOG(INFO) << "Existing loggers updated as well";
    Loggers::getLogger("testDefaultConf2");
    CLOG(INFO, "testDefaultConf2") << "Logging using new logger 2";
}

int main(int argc, char** argv) {
    
    _START_EASYLOGGINGPP(argc, argv);
    run();

    return 0;
}
