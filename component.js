import React from "react";
import useFormValidation from "./useFormValidation";

const MyForm = () => {
  const initialValues = { email: "", password: "" };
  const validationRules = {
    email: {
      required: true,
      pattern: /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/,
      message: "Invalid email address",
    },
    password: {
      required: true,
      minLength: 6,
      message: "Password must be at least 6 characters",
    },
  };

  const { values, errors, isValid, handleChange } = useFormValidation(
    initialValues,
    validationRules
  );

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isValid) {
      console.log("Form submitted with values:", values);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Email</label>
        <input
          type="text"
          name="email"
          value={values.email}
          onChange={handleChange}
        />
        {errors.email && <p>{errors.email}</p>}
      </div>
      <div>
        <label>Password</label>
        <input
          type="password"
          name="password"
          value={values.password}
          onChange={handleChange}
        />
        {errors.password && <p>{errors.password}</p>}
      </div>
      <button type="submit" disabled={!isValid}>
        Submit
      </button>
    </form>
  );
};

export default MyForm;
