package duke.command;

import duke.DukeException;
import duke.Messages;
import duke.Storage;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;

public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";
    private String description;
    private String dateTime;

    public EventCommand(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        assert tasks != null;
        assert storage != null;
        assert description != null;
        assert dateTime != null;

        Task newTask = new Event(description, dateTime);
        tasks.add(newTask);
        return Messages.getAddTaskMessage(newTask, tasks.size());
    }
}
