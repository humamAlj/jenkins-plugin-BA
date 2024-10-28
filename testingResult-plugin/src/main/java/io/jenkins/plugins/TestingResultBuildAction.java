package io.jenkins.plugins;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.Run;
import hudson.tasks.Notifier;

public class TestingResultBuildAction extends Notifier implements Action {
    private final AbstractBuild<?, ?> build;

    public TestingResultBuildAction(AbstractBuild<?, ?> build) {
        super();
        this.build = build;
    }

    @Override
    public String getDisplayName() {
        return "Build Ergebnisse anzeigen";
    }

    @Override
    public String getUrlName() {
        return "buildErgebnisse";
    }

    @Override
    public String getIconFileName() {
        return "notepad.png";
    }

    public String getTitle() {
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

    public String getCustomMessage() {
        return "This is a simple message displayed by the Action!";
    }
}
