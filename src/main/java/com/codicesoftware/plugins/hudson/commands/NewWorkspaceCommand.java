package com.codicesoftware.plugins.hudson.commands;

import com.codicesoftware.plugins.hudson.util.MaskedArgumentListBuilder;
import hudson.FilePath;

public class NewWorkspaceCommand extends AbstractCommand {
    private final String workspaceName;
    private final FilePath workspacePath;
    private final FilePath selectorPath;

    public NewWorkspaceCommand(
            ServerConfigurationProvider provider,
            String workspaceName,
            FilePath workspacePath,
            FilePath selectorPath) {
        super(provider);
        this.workspaceName = workspaceName;
        this.workspacePath = workspacePath;
        this.selectorPath = selectorPath;
    }

    public MaskedArgumentListBuilder getArguments() {
        MaskedArgumentListBuilder arguments = new MaskedArgumentListBuilder();

        arguments.add("mkwk");
        arguments.add(workspaceName);
        arguments.add(workspacePath.getRemote());
        arguments.add("--selector=" + selectorPath.getRemote());

        return arguments;
    }
}