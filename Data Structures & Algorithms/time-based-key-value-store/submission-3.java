class TimeMap {
    HashMap<String,ArrayList<Integer>> keyToTimes ;
    HashMap<String,HashMap<Integer,String>> keyToValues ;
    public TimeMap() {
        this.keyToTimes = new HashMap<>();
        this.keyToValues = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer,String> timeToValues = keyToValues.getOrDefault(key,new HashMap<>());
        timeToValues.put(timestamp,value);
        keyToValues.put(key,timeToValues);
        ArrayList<Integer> times = keyToTimes.getOrDefault(key, new ArrayList<>());
        times.add(timestamp);
        keyToTimes.put(key,times);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Integer> times = keyToTimes.get(key);
        if(times == null)
            return "";
        int time = determineTimeForValue(times, timestamp);

        HashMap<Integer,String> timeToValue = keyToValues.get(key);
        return time == -1? "" :timeToValue.get(time);

    }

    private int determineTimeForValue(ArrayList<Integer> times, int timestamp){
        int left = 0;
        int right = times.size()-1;
        int time = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(timestamp == times.get(mid))
                return timestamp;
            if(timestamp < times.get(mid)){
                right = mid-1;
            } else {
                time = Math.max(times.get(mid),time);
                left = mid+1;
            }
        }
        return time;
    }
}