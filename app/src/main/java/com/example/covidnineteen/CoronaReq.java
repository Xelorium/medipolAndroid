package com.example.covidnineteen;

public class CoronaReq extends BaseReq {

    public CoronaReqListener listener;

    public interface CoronaReqListener {
        void coronaReqDone(String result);
    }

    public CoronaReq(CoronaReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/worldstat.php?rapidapi-key=654f8368f9mshc5071ebe37efeddp186d1fjsn50ba20ce2aac";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.coronaReqDone(result);
    }
}
