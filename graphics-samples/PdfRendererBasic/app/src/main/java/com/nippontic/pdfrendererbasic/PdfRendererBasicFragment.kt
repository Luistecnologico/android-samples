package com.nippontic.pdfrendererbasic

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

/**
 * This fragment has a big [ImageView] that shows PDF pages, and 2 [Button]s to move between pages.
 */
class PdfRendererBasicFragment : Fragment(R.layout.pdf_renderer_basic_fragment) {

    private val viewModel: PdfRendererBasicViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // View references.
        val image: ImageView = view.findViewById(R.id.image)
        val buttonPrevious: Button = view.findViewById(R.id.previous)
        val buttonNext: Button = view.findViewById(R.id.next)

        // Bind data.
        viewModel.pageInfo.observe(viewLifecycleOwner) { (index, count) ->
            activity?.title = getString(R.string.app_name_with_index, index + 1, count)
        }
        viewModel.pageBitmap.observe(viewLifecycleOwner, Observer { image.setImageBitmap(it) })
        viewModel.previousEnabled.observe(viewLifecycleOwner, Observer {
            buttonPrevious.isEnabled = it
        })
        viewModel.nextEnabled.observe(viewLifecycleOwner, Observer {
            buttonNext.isEnabled = it
        })

        // Bind events.
        buttonPrevious.setOnClickListener { viewModel.showPrevious() }
        buttonNext.setOnClickListener { viewModel.showNext() }
    }
}