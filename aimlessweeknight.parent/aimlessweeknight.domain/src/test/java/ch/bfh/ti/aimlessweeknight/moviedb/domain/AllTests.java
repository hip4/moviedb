package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateIT.class, ReadIT.class, UpdateIT.class, DeleteIT.class})
public class AllTests {

}
