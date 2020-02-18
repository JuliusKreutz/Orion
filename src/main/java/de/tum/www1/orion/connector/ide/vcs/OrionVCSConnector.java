package de.tum.www1.orion.connector.ide.vcs;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import de.tum.www1.orion.connector.ide.OrionConnector;
import de.tum.www1.orion.connector.ide.vcs.submit.ChangeSubmissionContext;
import de.tum.www1.orion.dto.RepositoryType;
import de.tum.www1.orion.util.registry.OrionInstructorExerciseRegistry;

public class OrionVCSConnector extends OrionConnector implements IOrionVCSConnector {

    public OrionVCSConnector(Project project) {
        super(project);
    }

    @Override
    public void submit() {
        ServiceManager.getService(project, ChangeSubmissionContext.class).submitChanges();
    }

    @Override
    public void selectRepository(String repository) {
        final var parsedRepo = RepositoryType.valueOf(repository);
        ServiceManager.getService(project, OrionInstructorExerciseRegistry.class).setSelectedRepository(parsedRepo);
    }
}
