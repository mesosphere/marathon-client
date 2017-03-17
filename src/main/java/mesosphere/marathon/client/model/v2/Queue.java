package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.client.common.ModelUtils;

public class Queue {
    private List<QueueTask> queue;

    public List<QueueTask> getQueue() {
        return queue;
    }

    public void setQueue(List<QueueTask> queue) {
        this.queue = queue;
    }

    public static class QueueTask {
        private App app;
        private Integer count;
        private Delay delay;

        public App getApp() {
            return app;
        }

        public void setApp(App app) {
            this.app = app;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Delay getDelay() {
            return delay;
        }

        public void setDelay(Delay delay) {
            this.delay = delay;
        }

        public static class Delay {
            private Integer timeLeftSeconds;
            private Boolean overdue;

            public Integer getTimeLeftSeconds() {
                return timeLeftSeconds;
            }

            public void setTimeLeftSeconds(Integer timeLeftSeconds) {
                this.timeLeftSeconds = timeLeftSeconds;
            }

            public Boolean getOverdue() {
                return overdue;
            }

            public void setOverdue(Boolean overdue) {
                this.overdue = overdue;
            }

            @Override
            public String toString() {
                return ModelUtils.toString(this);
            }
        }

        @Override
        public String toString() {
            return ModelUtils.toString(this);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
