package ec.edu.uce.model;

import java.util.Date;
import java.util.List;

public class MarsPhoto {
    private int id;
    private int sol;
    private Camera camera;
    private String img_src;
    private Date earth_date;
    private Rover rover;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSol() {
        return sol;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public Date getEarth_date() {
        return earth_date;
    }

    public void setEarth_date(Date earth_date) {
        this.earth_date = earth_date;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public static class Camera {
        private int id;
        private String name;
        private int rover_id;
        private String full_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRover_id() {
            return rover_id;
        }

        public void setRover_id(int rover_id) {
            this.rover_id = rover_id;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }
    }

    public static class Rover {
        private int id;
        private String name;
        private Date landing_date;
        private Date launch_date;
        private String status;
        private int max_sol;
        private Date max_date;
        private int total_photos;
        private List<Camera> cameras;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getLanding_date() {
            return landing_date;
        }

        public void setLanding_date(Date landing_date) {
            this.landing_date = landing_date;
        }

        public Date getLaunch_date() {
            return launch_date;
        }

        public void setLaunch_date(Date launch_date) {
            this.launch_date = launch_date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getMax_sol() {
            return max_sol;
        }

        public void setMax_sol(int max_sol) {
            this.max_sol = max_sol;
        }

        public Date getMax_date() {
            return max_date;
        }

        public void setMax_date(Date max_date) {
            this.max_date = max_date;
        }

        public int getTotal_photos() {
            return total_photos;
        }

        public void setTotal_photos(int total_photos) {
            this.total_photos = total_photos;
        }

        public List<Camera> getCameras() {
            return cameras;
        }

        public void setCameras(List<Camera> cameras) {
            this.cameras = cameras;
        }
// getters and setters
    }
}
