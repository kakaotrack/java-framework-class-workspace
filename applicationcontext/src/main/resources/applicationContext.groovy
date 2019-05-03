import kr.ac.jejunu.applicationcontext.HelloImpl
import kr.ac.jejunu.applicationcontext.HelloPerson

beans {
    hello(HelloImpl) {
    }
    helloPerson(HelloPerson, hello) {
        name = 'hulk'
    }
}