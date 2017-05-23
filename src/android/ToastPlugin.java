package com.jty.app.plugin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

/**
 * @author TaoYuan
 * @time 2017/5/18 0018
 * @desc
 */

public class ToastPlugin extends CordovaPlugin{

    @Override
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {

        if("dialog".equals(action)){
            AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity());
            builder.setTitle("Tip");
            builder.setMessage(args.getString(0));
            builder.setPositiveButton("config", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    callbackContext.success("click config");
                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    callbackContext.error("click cancel");
                }
            });
            builder.create().show();
            return true;
        }else if("show".equals(action)){
            Toast.makeText(cordova.getActivity(),args.getString(0),Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
