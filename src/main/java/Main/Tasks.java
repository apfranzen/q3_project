package Main;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by adamfranzen on 11/10/16.
 */
public class Tasks {
        private String id;
        private String name;
        private String pomodoros;
        private Boolean complete;
        private String status;

        public Tasks(String id, String name, String pomodoros, Boolean complete, String status) {
            this.id = id;
            this.name = name;
            this.pomodoros = pomodoros;
            this.pomodoros = pomodoros;
            this.complete = complete;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPomodoros() {
            return this.pomodoros;
        }

        public String setPomodoros(String pomodoros) {
            return this.pomodoros = pomodoros;
        }

        public Boolean getComplete() {
            return this.complete;
        }

        public void setComplete(Boolean complete) {
            this.complete = complete;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}



