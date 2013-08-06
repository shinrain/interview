#include<iostream>
#include "../Logging.h"

using namespace std;

int main(int argc, char** argv) {
	_START_EASYLOGGINGPP(argc, argv);
	Logging* log = Logging::initLogger("log");
	log->linfo("Start function:");
	int i = 10;
	//log->linfo("Input i = "+i);
	for (int j =0;j<i;j++){
		//log->linfo("j = "+j);
		int k =2 *j;
		//log->linfo(" k = "+k);
	}
	log->linfo("Exit.");
	return 0;
}
