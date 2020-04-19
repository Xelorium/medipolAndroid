package com.example.covidnineteen;

public class CoronaImgReq extends BaseReq {
    public CoronaImgReq.CoronaImgReqListener listener;

    public interface CoronaImgReqListener {
        void coronaImgReqDone(String result);
    }

    public CoronaImgReq(CoronaImgReq.CoronaImgReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=81562325e2mshbd0d89553a475b7p15c935jsn5518849f9136";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.coronaImgReqDone(result);
    }
}
