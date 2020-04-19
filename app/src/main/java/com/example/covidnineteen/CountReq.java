package com.example.covidnineteen;

public class CountReq extends BaseReq {

    public CountReq.CountReqListener listener;

    public interface CountReqListener {
        void countReqDone(String result);
    }

    public CountReq(CountReq.CountReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php?rapidapi-key=81562325e2mshbd0d89553a475b7p15c935jsn5518849f9136";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.countReqDone(result);
    }
}
