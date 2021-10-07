package com.example.newnoteapp.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.newnoteapp.R;

public class AlertDialogFragment extends DialogFragment {

    public static final String KEY = "AlertDialogFragment";
    public static final String ARG_WHICH = "ARG_WHICH";
    public static final String ARG_TITLE = "ARG_TITLE";

    public static AlertDialogFragment newInstance(@StringRes int title) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TITLE, title);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DialogInterface.OnClickListener listener = (dialog, which) -> publishResults(which);

        return new AlertDialog.Builder(requireContext())
                .setTitle(requireArguments().getInt(ARG_TITLE))
                .setMessage(R.string.alert_message)
                .setIcon(R.drawable.ic_info)
                .setPositiveButton(R.string.positive, listener)
                .setNegativeButton(R.string.negative, listener)
                .setNeutralButton(R.string.neutral, listener)
                .create();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setCancelable(false);
    }

    private void publishResults(int which) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_WHICH, which);

        getParentFragmentManager().setFragmentResult(KEY, bundle);
    }
}
