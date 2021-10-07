package com.example.newnoteapp.ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.newnoteapp.R;
import com.google.android.material.snackbar.Snackbar;

public class InfoFragment extends Fragment {
    public InfoFragment() {
        super(R.layout.fragment_info);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getChildFragmentManager().setFragmentResultListener(AlertDialogFragment.KEY, getViewLifecycleOwner(), (requestKey, result) -> {
            int which = result.getInt(AlertDialogFragment.ARG_WHICH);

            switch (which) {
                case DialogInterface.BUTTON_NEGATIVE:
                    Snackbar.make(getView(), "BUTTON_NEGATIVE", Snackbar.LENGTH_SHORT).show();
                    break;

                case DialogInterface.BUTTON_POSITIVE:
                    Snackbar.make(getView(), "BUTTON_POSITIVE", Snackbar.LENGTH_SHORT).show();

                    break;

                case DialogInterface.BUTTON_NEUTRAL:
                    Snackbar.make(getView(), "BUTTON_NEUTRAL", Snackbar.LENGTH_SHORT).show();
                    break;
            }
        });

        view.findViewById(R.id.alert).setOnClickListener(v -> showSimpleAlert());

        view.findViewById(R.id.alert_list).setOnClickListener(v -> showListAlertDialog());

        view.findViewById(R.id.alert_single_choice).setOnClickListener(v -> showAlertSingleChoiceDialog());

        view.findViewById(R.id.alert_multiple_choice).setOnClickListener(v -> showAlertMultipleChoiceDialog());

        view.findViewById(R.id.alert_custom_view).setOnClickListener(v -> showAlertCustomViewDialog());

        view.findViewById(R.id.alert_dialog_fragment).setOnClickListener(v -> showAlertDialogFragment());

        view.findViewById(R.id.custom_dialog_fragment).setOnClickListener(v -> showCustomDialogFragment());

        view.findViewById(R.id.bottom_sheet_dialog_fragment).setOnClickListener(v -> showBottomSheetDialogFragment());

    }

    private void showBottomSheetDialogFragment() {
        CustomBottomSheetDialogFragment.newInstance().show(getChildFragmentManager(), "CustomBottomSheetDialogFragment");
    }

    private void showCustomDialogFragment() {

        CustomDialogFragment.newInstance()
                .show(getChildFragmentManager(), "CustomDialogFragment");

    }

    private void showAlertDialogFragment() {

        AlertDialogFragment.newInstance(R.string.alert_title).show(getChildFragmentManager(), "AlertDialogFragment");

        getChildFragmentManager().findFragmentByTag("AlertDialogFragment");

    }

    private void showAlertCustomViewDialog() {

        View customView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_edit_text, null);

        EditText editText = customView.findViewById(R.id.edit_text);

        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setTitle(R.string.alert_title)
                .setView(customView)
                .setIcon(R.drawable.ic_info)
                .setPositiveButton(R.string.positive, (dialog1, which) -> Snackbar.make(getView(), editText.getText(), Snackbar.LENGTH_SHORT).show())
                .setNegativeButton(R.string.negative, (dialog12, which) -> Snackbar.make(getView(), "negative", Snackbar.LENGTH_SHORT).show())
                .setNeutralButton(R.string.neutral, (dialog13, which) -> Snackbar.make(getView(), "neutral", Snackbar.LENGTH_SHORT).show())
                .create();

        dialog.show();

    }

    private void showAlertMultipleChoiceDialog() {
        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};

        final boolean[] selected = new boolean[items.length];

        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setTitle(R.string.alert_title)
                .setMultiChoiceItems(items, selected, (dialog1, which, isChecked) -> selected[which] = isChecked)
                .setPositiveButton(R.string.positive, (dialog12, which) -> {

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < items.length; i++) {
                        if (selected[i]) {
                            stringBuilder.append(items[i]);
                            stringBuilder.append(", ");
                        }
                    }

                    Snackbar.make(getView(), stringBuilder.toString(), Snackbar.LENGTH_SHORT).show();
                })
                .setNegativeButton(R.string.negative, null)
                .create();

        dialog.show();
    }

    private void showAlertSingleChoiceDialog() {

        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};

        final int[] selected = {-1};

        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setTitle(R.string.alert_title)
                .setSingleChoiceItems(items, -1, (dialog1, which) -> selected[0] = which)
                .setPositiveButton(R.string.positive, (dialog12, which) -> Snackbar.make(getView(), items[selected[0]], Snackbar.LENGTH_SHORT).show())
                .setNegativeButton(R.string.negative, null)
                .create();

        dialog.show();
    }

    private void showListAlertDialog() {

        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};

        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setItems(items, (dialog1, which) -> Snackbar.make(getView(), items[which], Snackbar.LENGTH_SHORT).show())
                .create();

        dialog.show();
    }

    private void showSimpleAlert() {
        AlertDialog dialog = new AlertDialog.Builder(requireContext())
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setIcon(R.drawable.ic_info)
                .setCancelable(false)
                .setPositiveButton(R.string.positive, (dialog1, which) -> Snackbar.make(getView(), "Positive", Snackbar.LENGTH_SHORT).show())
                .setNegativeButton(R.string.negative, (dialog12, which) -> Snackbar.make(getView(), "negative", Snackbar.LENGTH_SHORT).show())
                .setNeutralButton(R.string.neutral, (dialog13, which) -> Snackbar.make(getView(), "neutral", Snackbar.LENGTH_SHORT).show())
                .create();

        dialog.show();
    }
}
