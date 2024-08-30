import { useState, useEffect } from "react";

const useFormValidation = (initialValues, validationRules) => {
  const [values, setValues] = useState(initialValues);
  const [errors, setErrors] = useState({});
  const [isValid, setIsValid] = useState(false);

  useEffect(() => {
    validate();
  }, [values]);

  const validate = () => {
    let newErrors = {};
    let valid = true;

    for (const field in validationRules) {
      if (validationRules.hasOwnProperty(field)) {
        const rules = validationRules[field];
        const value = values[field] || "";

        if (rules.required && !value) {
          newErrors[field] = "This field is required";
          valid = false;
        } else if (rules.pattern && !rules.pattern.test(value)) {
          newErrors[field] = rules.message || "Invalid value";
          valid = false;
        } else {
          newErrors[field] = "";
        }
      }
    }

    setErrors(newErrors);
    setIsValid(valid);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
  };

  return { values, errors, isValid, handleChange };
};

export default useFormValidation;
