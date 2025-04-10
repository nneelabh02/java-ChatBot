package com.chatbot;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class MLIntentDetector {
    private FilteredClassifier model;
    private Instances structure;

    public MLIntentDetector(String datasetPath) throws Exception {
        DataSource source = new DataSource(datasetPath);
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        StringToWordVector filter = new StringToWordVector();
        filter.setInputFormat(data);

        NaiveBayes nb = new NaiveBayes();

        model = new FilteredClassifier();
        model.setFilter(filter);
        model.setClassifier(nb);
        model.buildClassifier(data);

        // Save structure for future inputs
        structure = new Instances(data, 0);
    }

    public String predictIntent(String input) throws Exception {
        Instance instance = new DenseInstance(2);
        instance.setDataset(structure);
        instance.setValue(0, input);

        double labelIndex = model.classifyInstance(instance);
        return structure.classAttribute().value((int) labelIndex);
    }
}
