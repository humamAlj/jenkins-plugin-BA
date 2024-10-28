package io.jenkins.plugins;

import hudson.model.AbstractBuild;
import hudson.model.Run;

public class TestingResultBuildAction extends TestingBaseAction {
    private AbstractBuild<?, ?> build;

    public TestingResultBuildAction(AbstractBuild<?, ?> build) {
        super();
        this.build = build;
    }

    protected String getTitle() {
        return this.build.getDisplayName();
    }
    /*
       @Override
       protected File dir() {
           return new File(build.getRootDir(), "testingResultBuild");
       }
    */
    public Run<?, ?> getBuild() {
        return build;
    }
}
