/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package App;

import App.util.FileUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {

    private App app;
    private Repository repository;
    private List<String> result;
    private String[] args;
    private List<String> expected;

    @BeforeEach
    void setUp() {
        repository = new Repository();
        app = new App();
        FileUtil.clear();
    }

    @Nested
    class list {
        @Test
        void should_list_format_tasks() {
            args = new String[]{"list"};
            final var expected = List.of(
                    "# To be done",
                    "Empty",
                    "# Completed",
                    "Empty"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should list empty todo", expected, result);

        }
    }

    @Nested
    class add {
        @Test
        void should_add_single_word_task() {
            args = new String[]{"add", "Task-001"};
            expected = List.of(
                    "# To be done",
                    "1 Task-001",
                    "# Completed",
                    "Empty"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should add single task", expected, result);
        }

        @Test
        void should_add_multiple_word_task() {
            args = new String[]{"add", "This", "is", "a", "multiple", "word", "task"};
            expected = List.of(
                    "# To be done",
                    "1 This is a multiple word task",
                    "# Completed",
                    "Empty"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should add single task", expected, result);
        }
    }

    @Nested
    class mark {
        @BeforeEach
        void add_something_to_tasks() {
            var lines = List.of("Task-001", "Task-002", "Task-003", "Task-004", "Task-005");
            lines.forEach(l -> repository.addTask(l));
            app.run("mark", "4", "5");
        }

        @Test
        void should_mark_single_task() {
            args = new String[]{"mark", "1"};

            expected = List.of(
                    "# To be done",
                    "2 Task-002",
                    "3 Task-003",
                    "# Completed",
                    "1 Task-001",
                    "4 Task-004",
                    "5 Task-005"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should add single task", expected, result);
        }

        @Test
        void should_mark_multiple_task() {
            args = new String[]{"mark", "1", "2"};

            expected = List.of(
                    "# To be done",
                    "3 Task-003",
                    "# Completed",
                    "1 Task-001",
                    "2 Task-002",
                    "4 Task-004",
                    "5 Task-005"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should add single task", expected, result);
        }

        @Test
        void should_unmark_task() {
            args = new String[]{"unmark", "4"};

            expected = List.of(
                    "# To be done",
                    "1 Task-001",
                    "2 Task-002",
                    "3 Task-003",
                    "4 Task-004",
                    "# Completed",
                    "5 Task-005"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("should add single task", expected, result);
        }
    }

    @Nested
    class remove {
        @BeforeEach
        void add_something() {
            var lines = List.of("Task-001", "Task-002", "Task-003", "Task-004", "Task-005");
            repository.reset();
            lines.forEach(l -> repository.addTask(l));
        }

        @Test
        void should_remove_single_task() {
            args = new String[]{"remove", "5"};
            expected = List.of(
                    "# To be done",
                    "1 Task-001",
                    "2 Task-002",
                    "3 Task-003",
                    "4 Task-004",
                    "# Completed",
                    "Empty"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("delete id 4", expected, result);
        }

        @Test
        void should_remove_multiple_task() {
            args = new String[]{"remove", "5", "4", "3"};
            expected = List.of(
                    "# To be done",
                    "1 Task-001",
                    "2 Task-002",
                    "# Completed",
                    "Empty"
            );

            app.run(args);
            result = repository.getTaskLines();

            Assert.assertEquals("delete id 3,4,5", expected, result);
        }
    }
}
